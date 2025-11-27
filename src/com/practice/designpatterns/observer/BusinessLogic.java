package com.practice.designpatterns.observer;

public class BusinessLogic {

	public static void main(String[] args) {
			Subscriber nilesh = new StatefulSubscriber("nilesh");
			Subscriber madan = new StatefulSubscriber("madan");
			
		    Channel youtubeChannel = new YoutubeChannel("Happy Faces");
		    youtubeChannel.subscribe(nilesh);
		    youtubeChannel.subscribe(madan);
		    youtubeChannel.notifySubscribers("Uploaded Video about Law of Attraction");
		    
		    youtubeChannel.unsubscribe(nilesh);
		    youtubeChannel.notifySubscribers("Uploaded video about Progeny");
	}

}
