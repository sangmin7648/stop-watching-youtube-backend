package com.foo.stopwatchingyoutube.channel;

import com.foo.stopwatchingyoutube.channel.transfer.Channel;
import com.foo.stopwatchingyoutube.channel.domain.ChannelBlacklist;

import java.util.List;

public interface ChannelService {
    ChannelBlacklist getBlacklist();
    ChannelBlacklist createBlackList(List<Channel> channelBlacklist);
    ChannelBlacklist removeChannelsFromBlacklist(List<Channel> channelList);
}
