# LR_Parameterization_Automation
This code copies .prm &amp; .dat files from source script folder to destination script folder (Loadrunner).
In today's Agile/Devops world one major challenge for Performance Testers is to make the brand new script work like an existing script.
As part of the script customization parameterization is one of the important aspects. 
In some scripts it is simply one or two parameters. However when we have to deal with multiple paramters to be re-created 
in the new script and doing them manually might be error prone and it takes significant amount of time.
Considering that this utility is developed to to automate the process of bringing the existing parameters and paramterfiles
from  existing script to new script that is generated.

Steps to use
1. Download the jar file to any local folder.
2. Open command prompt and navigate to that folder.
3. Execute the following  command- "jar (source script folder path) (destination or newly created script folder path)"
Example - autoparams.jar C:\\LR\\LRUtils\\WebHttpHtml3 C:\\LR\\LRUtils\\WebHttpHtml4
4. Verify that all the .prm files and .dat files are copied to new script folder.
5. Don't forget to do the following in your LR script - Just replace the hard coded values in the script with respective parameters. Example - 12345 -> {User_Id}
