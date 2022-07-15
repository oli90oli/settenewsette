

package com.sette.clipping.main.watcher;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "rss")
public class Rss {
	private List<Channel> channel;

	@XmlElement(name = "channel")
	public List<Channel> getChannel() {
		return channel;
	}

	public void setChannel(List<Channel> channel) {
		this.channel = channel;
	}

}



