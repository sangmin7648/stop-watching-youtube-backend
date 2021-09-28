package com.foo.stopwatchingyoutube.channel.repository;

import com.foo.stopwatchingyoutube.channel.domain.Channel;
import com.foo.stopwatchingyoutube.channel.domain.ChannelBlacklist;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("dev")
public class MemoryChannelRepository implements ChannelRepository {
    private final ChannelBlacklist channelBlacklist = new ChannelBlacklist();

    @Override
    public ChannelBlacklist getBlacklist() {
        return channelBlacklist;
    }

    @Override
    public ChannelBlacklist insertBlacklist(ChannelBlacklist channelBlacklist) {
        channelBlacklist.getChannelBlacklist().forEach(this.channelBlacklist::addChannel);
        return channelBlacklist;
    }

    @Override
    public void deleteChannelFromBlacklist(Channel channel) {
        channelBlacklist.removeChannel(channel);
    }
}
