/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.courses.core.util;

import javax.validation.Validation;
import javax.validation.Validator;

/**
 *
 * @author NGAL
 */
public class ValidatorFactory
{
    public static Validator getValidator ()
    {
      return Validation.buildDefaultValidatorFactory().getValidator();
    }
}
