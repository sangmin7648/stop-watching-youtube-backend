package com.foo.stopwatchingyoutube.channel.repository;

import com.foo.stopwatchingyoutube.channel.domain.Channel;
import com.foo.stopwatchingyoutube.channel.domain.ChannelBlacklist;

public interface ChannelRepository {
    ChannelBlacklist getBlacklist();
    ChannelBlacklist insertBlacklist(ChannelBlacklist channelBlacklist);
    void deleteChannelFromBlacklist(Channel channel);
}
