package br.pro.ramon.dcs.jaxrs.login;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    br.pro.ramon.dcs.jaxrs.login.LoginServiceTest.class,
    br.pro.ramon.dcs.jaxrs.login.LoginResourceTest.class,
    br.pro.ramon.dcs.jaxrs.login.LoginFormTest.class
})
public class AllTests {
}
