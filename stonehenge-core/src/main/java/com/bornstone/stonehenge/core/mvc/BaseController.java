package com.bornstone.stonehenge.core.mvc;

import com.bornstone.stonehenge.entity.IValidateAble;
import com.bornstone.stonehenge.entity.Identity;
import com.bornstone.stonehenge.manager.exception.EntityValidateFailureException;
import com.bornstone.stonehenge.manager.exception.ManagerException;
import com.bornstone.stonehenge.manager.query.IIdentityQueryAble;
import com.bornstone.stonehenge.manager.validate.StonehengeValidator;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

/**
 * Created by king on 15-5-11.
 */
public class BaseController {
    private static final Logger logger = Logger.getLogger(BaseController.class);

    public void validate(IValidateAble requestBean) throws ManagerException {
        try {
            StonehengeValidator.validate(requestBean);
        } catch (EntityValidateFailureException e) {
            throw new ManagerException(e.getMessage());
        }
    }

    protected void validateId(Integer id) throws ManagerException {
        if (id == null || id <= 0) {
            throw new ManagerException("必须指定ID");
        }
    }

    protected void validateIdWhenModify(Identity<Integer> modifyEntity) throws ManagerException {
        Integer id = modifyEntity.getId();
        validateId(id);
    }

    protected boolean isEnterAction(String action) {
        return StringUtils.isBlank(action);
    }

    protected Integer getSessionUserId(HttpSession session) {
        Identity<Integer> sessionUser = (Identity<Integer>) session.getAttribute(WebConstants.SESSION_USER);
        return sessionUser.getId();
    }

    protected <PK extends Number, T extends Identity<PK>> void putModifyEntityToModel(PK id, IIdentityQueryAble<PK, T> manager, Model model) {
        try {
            T entity = manager.queryById(id);
            model.addAttribute("action", "modify");
            model.addAttribute("entity", entity);
        } catch (ManagerException e) {
            logger.error(e.getMessage(), e);
            model.addAttribute("message", e.getMessage());
        }
    }
}
