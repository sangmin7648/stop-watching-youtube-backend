package com.foo.stopwatchingyoutube.channel.transfer.request;

import com.foo.stopwatchingyoutube.channel.transfer.Channel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class ChannelBlacklistRequest {
    public List<Channel> channelList;
}
