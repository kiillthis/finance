package com.netcracker.controllers;

import com.netcracker.dao.CreditAccountDao;
import com.netcracker.dao.CreditOperationDao;
import com.netcracker.dao.UserDao;
import com.netcracker.exception.CreditAccountException;
import com.netcracker.exception.ErrorsMap;
import com.netcracker.models.CreditOperation;
import com.netcracker.models.PersonalCreditAccount;
import com.netcracker.models.Status;
import com.netcracker.models.User;
import com.netcracker.services.PersonalCreditService;
import com.netcracker.services.utils.ExceptionMessages;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.security.Principal;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/personalCredit")
public class CreditPersonalController {
    @Autowired
    PersonalCreditService personalCreditService;
    @Autowired
    private UserIdController userController;
    private BigInteger debitId;
    @Autowired
    UserDao userDao;
    @Autowired
    CreditAccountDao creditAccountDao;
    private BigInteger creditId;
    @Autowired
    CreditOperationDao creditOperationDao;

    private static final Logger logger = Logger.getLogger(CreditPersonalController.class);

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Status createCreditAccount(@RequestBody PersonalCreditAccount creditAccount, Principal principal) {
        debitId = userController.getAccountByPrincipal(principal);
        logger.debug("[createCreditAccount]" + MessageController.debugStartMessage + "[debitId = " + debitId + "]");
        if (!personalCreditService.doesCreditWithNameNotExist(debitId, creditAccount.getName()))
            return new Status(false, MessageController.CREDIT_NAME_EXISTS);
        Status checked = personalCreditService.checkCreditData(creditAccount);
        if (!checked.isStatus()) return checked;
        personalCreditService.createPersonalCredit(debitId, creditAccount);
        return new Status(true, MessageController.ADD_PERSONAL_CREDIT + creditAccount.getName());
    }

    @RequestMapping(value = "/pay/{id}", method = RequestMethod.POST)
    public Status addPersonalCreditPayment(@RequestBody Double amount, Principal principal, @PathVariable("id") BigInteger crId) {
        debitId = userController.getAccountByPrincipal(principal);
        User user = userDao.getUserByEmail(principal.getName());
        logger.debug("[addPersonalCreditPayment]" + MessageController.debugStartMessage + "[debitId = " + debitId + "], [creditId = " + creditId + "]");
        try {
            personalCreditService.addPersonalCreditPayment(debitId, crId, amount);
        } catch (CreditAccountException ex) {
            return new Status(false, ex.getMessage());
        }
        return new Status(true, null);
//        double amount = Double.parseDouble(amountMap.get("amount"));
//        model.addAttribute("creditPayment", amount);
//        try {
//            personalCreditService.addPersonalCreditPayment(debitId, creditId, amount);
//        } catch (CreditAccountException ex) {
//            if (ex.getMessage().equals(ExceptionMessages.NOT_ENOUGH_MONEY_ERROR))
//                model.addAttribute("message", ErrorsMap.getErrorsMap().get(ExceptionMessages.NOT_ENOUGH_MONEY_ERROR));
//            else model.addAttribute("message", ex.getMessage());
//            return URL.EXCEPTION_PAGE;
//        }
//        return URL.PERSONAL_CREDIT;
    }

    @RequestMapping(value = "/getPersonalCredits", method = RequestMethod.GET)
    public @ResponseBody
    Collection<PersonalCreditAccount> getPersonalCredits(Principal principal) {
        debitId = userController.getAccountByPrincipal(principal);
        logger.debug("[getPersonalCredits]" + MessageController.debugStartMessage + "[debitId = " + debitId + "]");
        return personalCreditService.getPersonalCredits(debitId);
    }

    @RequestMapping(value = "/getPersonalCredit", method = RequestMethod.GET)
    public @ResponseBody
    PersonalCreditAccount getPersonalCredit() {
        logger.debug("[getPersonalCredit]" + MessageController.debugStartMessage + "[debitId = " + debitId + "], [creditId = " + creditId + "]");
        return creditAccountDao.getPersonalCreditById(creditId);
    }

    @RequestMapping(value = "/sendCreditId", method = RequestMethod.POST)
    public ResponseEntity<String> sendCreditId(@RequestBody BigInteger creditId) {
        logger.debug("[sendCreditId]" + MessageController.debugStartMessage + "[debitId = " + debitId + "], [creditId = " + creditId + "]");
        this.creditId = creditId;
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/deletePersonalCredit/{creditId}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deletePersonalCredit(@PathVariable("creditId") BigInteger creditId) {
        logger.debug("[deletePersonalCreditAccount]" + MessageController.debugStartMessage + "[debitId = " + debitId + "], [creditId = " + creditId + "]");
        creditAccountDao.deleteCreditAccountByCreditId(creditId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/updatePersonalCredit", method = RequestMethod.PUT)
    public ResponseEntity<PersonalCreditAccount> updatePersonalCreditAccount(@RequestBody PersonalCreditAccount personalCreditAccount) {
        logger.debug("[updatePersonalCredit]" + MessageController.debugStartMessage + "[debitId = " + debitId + "], [creditId = " + creditId + "]");
        creditAccountDao.updateCreditAccountByCreditId(personalCreditAccount, creditId);
        return new ResponseEntity<>(personalCreditAccount, HttpStatus.OK);
    }

    @RequestMapping(value = "/getCreditHistoryPersonal", method = RequestMethod.GET)
    public @ResponseBody List<CreditOperation> getCreditHistoryPersonal(){
        logger.debug("[getCreditHistoryPersonal]" + MessageController.debugStartMessage + "[personalDebitId = " + debitId +
                "], [creditId = " + creditId + "]");
        return creditOperationDao.getAllCreditOperationsByCreditPersonalId(creditId);
    }

}
