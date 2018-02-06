package test.com.maxim.jms.controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.maxim.jms.producer.controller.ProducerController;
import com.maxim.jms.producer.model.Vendor;

public class ProducerControllerTest {
	private Vendor vendor;
	private Model model;
	private ProducerController producerController;
	private ApplicationContext context;
	
	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("spring/application-config.xml");
		producerController = (ProducerController) context.getBean("producerController");
		vendor = new Vendor();
		vendor.setVendorName("UPS");
		vendor.setFirstName("Bob");
		vendor.setLastName("Thomas");
		vendor.setAddress("123 Main st");
		vendor.setCity("maintown");
		vendor.setState("iowa");
		vendor.setZipCode("12345");
		vendor.setEmail("bob@ups.com");
		vendor.setPhoneNumber("123-456-7890");	
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRenderVendorPage() {
		assertEquals("index", producerController.renderVendorPage(vendor, model));
	}

	@Test
	public void testProcessRequest() {
		ModelAndView mv = producerController.processRequest(vendor, model);
		assertEquals("index", mv.getViewName());
	}

}
