package app.daniele.patches.column

import app.daniele.patches.shared.Constants.COMPATIBILITY_COLUMN
import app.morphe.patcher.patch.PatchException
import app.morphe.patcher.patch.rawResourcePatch

/**
 * Vite web-app chunk defining the SubscriptionInfo class with its
 * isPremium()/isFreemium() entitlement helpers.
 */
private const val SUBSCRIPTION_CHUNK = "assets/public/chunk-MUU6R4WP.js"

/**
 * Original entitlement check: premium resolves true only when the entitlement
 * provided by the backend or RevenueCat equals PREMIUM and, when present, its
 * expiry timestamp is still in the future.
 */
private const val ORIGINAL_METHOD =
    "isPremium(){if(this.entitlement!==at.PREMIUM)return!1;" +
        "if(this.entitlement_expire_ts){let e=new Date().getTime();" +
        "return this.entitlement_expire_ts*1e3>e}return!0}"

/** Replacement body: the premium entitlement always resolves as active. */
private const val PATCHED_METHOD = "isPremium(){return!0}"

@Suppress("unused")
val unlockPremiumPatch = rawResourcePatch(
    name = "Unlock Premium",
    description = "Forces the premium entitlement to always resolve as active, " +
        "regardless of subscription or backend status. Support the original developer!",
    default = true,
) {
    compatibleWith(COMPATIBILITY_COLUMN)

    execute {
        val chunk = get(SUBSCRIPTION_CHUNK)
        val data = chunk.readBytes()

        // ISO-8859-1 maps every byte to exactly one character, so the
        // round-trip below cannot alter any other byte of the file.
        val text = String(data, Charsets.ISO_8859_1)

        when {
            // Already patched, nothing to do.
            text.contains(PATCHED_METHOD) -> Unit
            text.contains(ORIGINAL_METHOD) -> {
                chunk.writeBytes(
                    text.replace(ORIGINAL_METHOD, PATCHED_METHOD)
                        .toByteArray(Charsets.ISO_8859_1),
                )
            }
            else -> throw PatchException(
                "Obsolete patch: the original isPremium() entitlement check was " +
                    "not found in $SUBSCRIPTION_CHUNK. This patch targets Column 1.3.7.",
            )
        }
    }
}
