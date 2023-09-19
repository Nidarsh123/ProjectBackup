package Generic_Utilities;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class ITransform implements IAnnotationTransformer {

	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method TestMethod)
	{
		annotation.setRetryAnalyzer(Generic_Utilities.RetryAnalyserImplementation.class);
	}
	
}
