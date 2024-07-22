package moitest;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SelectClasses;

@Suite
@SelectClasses({
        TestService.class,
        VoitureTest.class,
        TestTout.class
})
/*@IncludeEngines("junit-jupiter")
@SelectPackages("moitest")*/
public class AllTests {
}
