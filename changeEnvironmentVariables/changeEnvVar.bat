@echo off

REM cerner_2^5_2019

REM check if there are two arguments <variable name> <value>
if [%1]==[] (
    if [%2]==[] (
        echo NOT ENOUGH ARGUMENTS!
        goto eof
    )
)

:setVar
REM check if JAVA version is being changed
if /I "%1"=="JAVA" (
    if "%2"=="12" (
        REM Progra~1 is short for Program Files and 
        REM Progra~2 is short for Program Files (x86)
        set JAVA_HOME=C:\Program Files\Java\jdk-12.0.2
        set "PATH=C:\Program Files\Java\jdk-12.0.2\bin;%PATH%"
    ) else (
        if "%2"=="8" (
            set JAVA_HOME=C:\Program Files\Java\jdk1.8.0_221
            set "PATH=C:\Program Files\Java\jdk1.8.0_221\bin;%PATH%"
        ) else (
            if /I "%2"=="-v" (
                echo 8 12
            ) else (
                echo VERSION NOT FOUND!
            )
            goto eof
        )
    )
    java -version
    goto tempPath
)

REM setting new variable
set %1=%2
PATH=%2\bin;%PATH%

:tempPath
echo new temporary path: %PATH%

:eof
@echo Done setting env variable %1 with value %2