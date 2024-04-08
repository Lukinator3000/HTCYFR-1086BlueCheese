# HTCYFR Episode 3: Imaging and Installations

This GitHub page will provide links and information from the Imaging and Installations episode as well as some extra notes left out from the video.

## Video Notes

### Physical Requirements for Imaging

- A computer, ideally one with a SD or microSD port
- [microSD Card + Adapter](https://www.amazon.com/dp/B073K14CVB/?th=1): the microSD card is the device that will be imaged with the WPILibPi image to give the Romi firmware for it to function. This microSD card Amazon link also comes with an adapter that allows you to insert the microSD card into a regular SD card port
  - [microSD Card Reader](https://www.amazon.com/gp/product/B0779V61XB/): if your computer does not have a microSD or SD card port, then you will need to get the microSD Card Reader, which is essentially microSD and SD card adapter for USB ports
- USB A to micro-B Adapter Cable, which should be the white cable that comes with the Romi Robot Kit for FIRST box (check Episode 2 branch for more info)

### Extra Information

Here's some pieces of information from this branch's episode that I want to reemphasize:

- For the HTCYFR Tutorial Series, I will be using a Windows 11 laptop / operating system to go through the tutorial process. If you have a different brand of computer or operating system, the imaging and installations method and potentially future coding may look different than what's shown in the episode(s).
- The version of the Romi image I'm using is 2023.2.1, the latest full release of the Romi image at the time of making the video. I specifically downloaded the 64-bit version, but there's also a 32-bit version of the Romi image that you can download instead.
  - *Note: there may not be 32-bit version of the Romi image in future releases.*

I also want to list some pieces of information that I forgot to mention in the video or cut out for time.

- In the Romi Raspberry Pi Dashboard, you can change your Romi's Wi-Fi name (SSID) and password (WPA Passphrase) in the Network Settings section.
- In the Romi section of the Raspberry Pi Dashboard, you can calibrate your Romi's gyro (rotation sensor) in the box titled "IMU Calibration" to help your Romi senses its angle more accurately.
- The WPILib version I downloaded in the video was the 2023.2.3 release.
- When you see the four VSCode download options during the WPILibInstaller process, I said in the episode to select “Download VS Code for Single Install” option. I have now realized that the wording for that button option likely changed to "Download for this computer only (fastest)" in the recent versions, so please select that button.

## Important Sources

### Essential Links

Here's a list of links to all the major website and other applications gone through in the episode:

- [WPILibPi Image Release GitHub Page](https://github.com/wpilibsuite/WPILibPi/releases?scrlybrkr=aa6b855b): the place to download the latest WPILibPi image file for your microSD card
- [BalenaEtcher Website](https://etcher.balena.io/): the website to download BalenaEtcher for flashing the image
- [10.0.0.2](http://10.0.0.2/) or [wpilibpi.local](http://wpilibpi.local/): the link to access the Romi Raspberry Pi dashboard when connected to its Wi-Fi network
- [WPILib Release GitHub Page](https://github.com/wpilibsuite/allwpilib/releases/tag/v2024.3.1): the place to download the latest WPILib version, also found in the [WPILib Installation Guide section in the FRC Control System Docs](https://docs.wpilib.org/en/stable/docs/zero-to-robot/step-2/wpilib-setup.html)

### Additional Sources

Most of the information on imaging and installations from this episode was gathered from the following sources. Please check them out if you want more thorough tutorials.

- [FRC Control System Docs: Imaging your Romi section](https://docs.wpilib.org/en/stable/docs/zero-to-robot/step-2/wpilib-setup.html)
- [Adam Steinman's "Getting started with Romi for FIRST" YouTube video](https://www.youtube.com/watch?v=mop51tpWWcA)
