package com.foo.stopwatchingyoutube.channel.controller;

import com.foo.stopwatchingyoutube.channel.domain.Channel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class ChannelBlacklistRequest {
    public List<Channel> channelList;
}
