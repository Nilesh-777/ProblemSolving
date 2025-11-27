package com.practice.designpatterns.abstractfactory;

import com.practice.designpatterns.abstractfactory.aws.AWSCloudServiceFactory;
import com.practice.designpatterns.abstractfactory.google.GoogleCloudServiceFactory;

public class MainLogic {

	public static void main(String[] args) {
		// Run app on AWS
		{
			Application app = new Application(new AWSCloudServiceFactory());
			app.run();
		}
		// Run app on Google Cloud
		{
			Application app = new Application(new GoogleCloudServiceFactory());
			app.run();
		}

	}

}
