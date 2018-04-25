package by.htp.testreport.util;

import java.io.Serializable;

import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;
import org.apache.logging.log4j.core.layout.AbstractStringLayout;
import org.testng.Reporter;

@Plugin(name = "Stub", category = "Core", elementType = "appender", printObject = true)
public class TestNGReportAppender extends AbstractAppender {

	private TestNGReportAppender(final String name, final Layout layout) {
		super(name, null, layout, false);
	}

	@PluginFactory
	public static TestNGReportAppender createAppender(
			@PluginAttribute("name") @Required(message = "A name for the Appender must be specified") final String name,
			@PluginElement("Layout") Layout<? extends Serializable> layout) {
		return new TestNGReportAppender(name, layout);
	}

	@Override
	public void append(LogEvent event) {
		final Layout<? extends Serializable> layout = getLayout();
		if (layout != null && layout instanceof AbstractStringLayout) {
			Reporter.log(((AbstractStringLayout) layout).toSerializable(event));
		} else {
			Reporter.log(event.getMessage().getFormattedMessage());
		}

	}
}