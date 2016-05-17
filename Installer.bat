@echo OFF
if NOT EXIST "%HOMEDRIVE%%HOMEPATH%\AppData\Roaming\TextAdventure" mkdir "%HOMEDRIVE%%HOMEPATH%\AppData\Roaming\TextAdventure"
xcopy "%HOMEDRIVE%%HOMEPATH%\AppData\Local\Temp\IXP000.TMP"  "%HOMEDRIVE%%HOMEPATH%\AppData\Roaming\TextAdventure"

set SCRIPT="%TEMP%\%RANDOM%-%RANDOM%-%RANDOM%-%RANDOM%.vbs"

echo Set oWS = WScript.CreateObject("WScript.Shell") >> %SCRIPT%
echo sLinkFile = "%USERPROFILE%\Desktop\Text Adventure.lnk" >> %SCRIPT%
echo Set oLink = oWS.CreateShortcut(sLinkFile) >> %SCRIPT%
echo oLink.TargetPath = "%HOMEDRIVE%%HOMEPATH%\AppData\Roaming\TextAdventure\Run.bat" >> %SCRIPT%
echo oLink.IconLocation = "%HOMEDRIVE%%HOMEPATH%\AppData\Roaming\TextAdventure\RPGIcon.ico" >> %SCRIPT%
echo  oLink.WorkingDirectory = "%HOMEDRIVE%%HOMEPATH%\AppData\Roaming\TextAdventure" >> %SCRIPT%
echo oLink.Save >> %SCRIPT%

cscript /nologo %SCRIPT%
del %SCRIPT%
