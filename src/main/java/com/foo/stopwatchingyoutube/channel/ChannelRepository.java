package com.foo.stopwatchingyoutube.channel;

import com.foo.stopwatchingyoutube.channel.transfer.Channel;
import com.foo.stopwatchingyoutube.channel.domain.ChannelBlacklist;

public interface ChannelRepository {
    ChannelBlacklist getBlacklist();
    ChannelBlacklist insertBlacklist(ChannelBlacklist channelBlacklist);
    void deleteChannelFromBlacklist(Channel channel);
}
