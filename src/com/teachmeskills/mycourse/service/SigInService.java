package com.teachmeskills.mycourse.service;

import com.teachmeskills.mycourse.controller.pars_document.FileParser;
import com.teachmeskills.mycourse.exception.CheckLoginException;
import com.teachmeskills.mycourse.exception.CheckPasswordException;
import com.teachmeskills.mycourse.logger.Logger;
import com.teachmeskills.mycourse.validation.CredValidate;

import java.io.File;
import java.util.Date;

public class SigInService {
    public static boolean sigIn (String login,String password) {
        Logger.logExecutionInfo(new Date(),"start sig in\n");
        boolean isSigIn = false;
        try {
            CredValidate.loginValidation(login);
            CredValidate.passwordValidation(password);
            isSigIn = true;
            Logger.logExecutionInfo(new Date(),"success sig in\n" );
        } catch (CheckLoginException | CheckPasswordException e) {
            Logger.LogErrorInfo(new Date(), e.getMessage(), e);
        }
        Logger.logExecutionInfo(new Date(),"end sif in\n");
        return isSigIn;
    }
    public static void pathFile(String path) {
        FileParser.filePars(new File(path));
    }
}
