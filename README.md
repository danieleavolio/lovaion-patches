# Lovaion Patches

> **PATCHED BY MORPHE** 🛠️ — all patches in this repository are built for and applied
> with [Morphe](https://morphe.software) / Morphe Manager.
>
> ❤️ **Support the original developers:** if you use these apps every day, consider
> subscribing or leaving a review — see [Support the original developers](#support-the-original-developers).

Morphe patches for the apps I use.

## Patches

<!-- PATCHES_START -->
> **[v1.0.0](https://github.com/danieleavolio/lovaion-patches/releases/tag/v1.0.0)**&nbsp;&nbsp;•&nbsp;&nbsp;`main`&nbsp;&nbsp;•&nbsp;&nbsp;2 patches total
<details open>
<summary>📦 Column&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 1.3.7 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Forces the premium entitlement to always resolve as active, regardless of subscription or backend status. Support the original developer! |  |

</details>

<details open>
<summary>📦 Cinemaniac&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 5.0.7 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Pro](#unlock-pro) | Forces the Pro entitlement to always resolve as active, regardless of purchase or backend status. Support the original developer! |  |

</details>

<!-- PATCHES_END -->

## Supported apps

| App | Package | Version |
|---|---|---|
| Cinemaniac | `it.papalillo.moviestowatch` | 5.0.7 |
| Column | `com.columnapp.column` | 1.3.7 (XAPK) |

## Apply

1. Get the original release of the app (the exact version listed above).
2. In Morphe Manager, add this repository as a remote patch source:
   - direct link: `https://morphe.software/add-source?github=danieleavolio/lovaion-patches`
   - or manual endpoint:
     `https://raw.githubusercontent.com/danieleavolio/lovaion-patches/main/patches-bundle.json`
   - or import the latest `patches-*.mpp` release asset as a local source.
3. Select the app, keep the patch enabled (both are on by default), patch and install.
   The original app must be uninstalled first (different signature).

## Build

Morphe's Gradle plugin is published on GitHub Packages, which requires authentication even
for public packages. Provide a token with the `read:packages` scope.

```bash
export GITHUB_ACTOR=your-username
export GITHUB_TOKEN=ghp_xxxxxxxxxxxxxxxxxxxx
./gradlew buildAndroid
```

Output: `patches/build/libs/patches-*.mpp`. See `BUILD.md` for the full setup.

## Support the original developers

- **Cinemaniac** is an independent one-person app by Antonio Papalillo: subscriptions are
  what keep it going.
- **Column** is an independent news product: the premium subscription is what keeps it alive.

If these apps are part of your day, the best thanks is a subscription and a good review.

## Credits & license

Based on the [Morphe patches template](https://github.com/MorpheApp/morphe-patches-template),
which derives from ReVanced. Licensed under GPLv3 — see `LICENSE` and `NOTICE`.
This project uses its own branding and is not affiliated with the Morphe project.
