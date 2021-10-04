package com.foo.stopwatchingyoutube.channel;

import com.foo.stopwatchingyoutube.channel.transfer.Channel;
import com.foo.stopwatchingyoutube.channel.domain.ChannelBlacklist;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class DefaultChannelService implements ChannelService{
    private final ChannelRepository channelRepository;
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public ChannelBlacklist getBlacklist() {
        return channelRepository.getBlacklist();
    }

    @Override
    public ChannelBlacklist createBlackList(List<Channel> channelList) {
        var channelBlacklist = new ChannelBlacklist(channelList);
        return channelRepository.insertBlacklist(channelBlacklist);
    }

    @Override
    @Transactional
    public ChannelBlacklist removeChannelsFromBlacklist(List<Channel> channelList) {
        log.info("channelList -> " + String.valueOf(channelList));
        var channelBlacklist = new ChannelBlacklist(channelList);
        channelBlacklist.getChannelBlacklist().forEach(channelRepository::deleteChannelFromBlacklist);
        return getBlacklist();
    }
}
