package com.foo.stopwatchingyoutube.channel;

import com.foo.stopwatchingyoutube.channel.domain.ChannelBlacklist;
import com.foo.stopwatchingyoutube.channel.transfer.request.ChannelBlacklistRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v0/channels")
@AllArgsConstructor
public class ChannelRestController {
    private ChannelService channelService;

    @GetMapping("/blacklist")
    public ChannelBlacklist getChannelBlacklist() {
        return channelService.getBlacklist();
    }

    @PutMapping("/blacklist")
    public ChannelBlacklist createChannelBlacklist(@RequestBody ChannelBlacklistRequest channelBlacklistRequest) {
        return channelService.createBlackList(channelBlacklistRequest.channelList);
    }

    @DeleteMapping("/blacklist")
    public ChannelBlacklist removeChannelsFromBlacklist(@RequestBody ChannelBlacklistRequest channelBlacklistRequest) {
        return channelService.removeChannelsFromBlacklist(channelBlacklistRequest.channelList);
    }

}
