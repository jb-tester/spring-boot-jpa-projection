
package com.mytests.spring.jpaProjections;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;


public class SimpleProjectionTests {

	ProjectionFactory factory = new SpelAwareProxyProjectionFactory();

	@Test
	public void createMapBackedProjection() {

		Contact contact = factory.createProjection(Contact.class);
		contact.setFirstname("Vasya");
		contact.setLastname("Pupkin");


		assertThat(contact.getFirstname(), is("Vasya"));
		assertThat(contact.getLastname(), is("Pupkin"));


		assertThat(contact.getFullName(), is("Vasya Pupkin"));
	}

	@Test
	public void createsProxyForSourceMap() {

		Map<String, Object> props = new HashMap<>();
		props.put("firstname", "Masha");
		props.put("lastname", "Popkina");

		Contact contact = factory.createProjection(Contact.class, props);


		assertThat(contact.getFirstname(), is("Masha"));
		assertThat(contact.getLastname(), is("Popkina"));
		assertThat(contact.getFullName(), is("Masha Popkina"));
	}

	interface Contact {

		String getFirstname();

		void setFirstname(String firstname);

		String getLastname();

		void setLastname(String lastname);

		@Value("#{target.firstname + ' ' + target.lastname}")
		String getFullName();
	}
}
