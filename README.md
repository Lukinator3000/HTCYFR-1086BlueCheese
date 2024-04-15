# HTCYFR Episode 4: WPILib and VS Code

## Moving onto Code

Now that we're getting into code, these README files will be a lot briefer for upcoming episode branches. Instead, there should be some documentation from me and WPILib to explain to you the code in the branch. With that said, there are some important things I want to clarify (some of which I already stated in the main branch README file):

- **The bulk of the code provided belongs to FIRST and WPILib!** For this tutorial series, I will primarily be writing on top of premade example code, including code comments, that was written by the contributors for FIRST and WPILib. The java files made by them should have a copyright statement at the top of the file, and there's also the WPILib-License.md file that describes their copyright conditions.
- **I will differentiate my own code comments with a "- ".** If you see a code comment "// - with a hyphen before it, like this" then it's my own documentation that I added to explain certain code aspects, mostly for the code I typed. Any other code comments without the leading hyphen is likely pre-written by WPILib.
- **Try to store your WPILib project folder outside of Windows OneDrive.** Recent Windows computers come with a file hosting service called OneDrive. While OneDrive can be helpful for saving files in any other context, setting your new WPILib project folder inside a OneDrive-managed directory may cause some errors when building and simulating the Romi. For Windows users, please find a folder not managed by OneDrive to place your new WPILib project in.

## Constants File

As talked about in this branch's episode, the constants file won't be used in this tutorial series. Despite this, Constants.java is very important and useful file that our team utilizes to store important, static variable constants like device IDs, robot measurements, and miscellenous values that can be easily accessed by the other files in java/frc/robot. To see an example of what a Constants file looks like, here's the [constants file from the MontyReborn repository](https://github.com/BlueCheese1086/MontyReborn/blob/main/src/main/java/frc/robot/Constants.java), a code rewrite of one of Blue Cheese's older robots Monterey Jack.
