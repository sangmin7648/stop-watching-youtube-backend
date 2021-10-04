package com.foo.stopwatchingyoutube.channel.domain;

import com.foo.stopwatchingyoutube.channel.transfer.Channel;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ChannelBlacklist {
    private final List<Channel> channelBlacklist;

    public ChannelBlacklist() {
        channelBlacklist = new ArrayList<>();
    }

    public ChannelBlacklist(List<Channel> channelList) {
        channelBlacklist = channelList;
    }

    public void addChannel(Channel channel) {
        if (!contains(channel))
            channelBlacklist.add(channel);
    }

    public void removeChannel(Channel channel) {
        channelBlacklist.remove(channel);
    }

    public boolean contains(Channel channel) {
        return channelBlacklist.stream()
            .anyMatch(blockedChannel -> blockedChannel.equals(channel));
    }

    @Override
    public String toString() {
        return channelBlacklist.toString();
    }
}
