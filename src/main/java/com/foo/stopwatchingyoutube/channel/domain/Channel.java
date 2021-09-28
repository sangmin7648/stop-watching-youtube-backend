package com.foo.stopwatchingyoutube.channel.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor
@Getter
public class Channel {
    private String channelName;

    public Channel(String channelName) {
        validateChannelName(channelName);
        this.channelName = channelName;
    }

    private void validateChannelName(String channelName) {
        if (channelName.length() == 0)
            throw new IllegalArgumentException("channel name cannot be empty");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Channel channel = (Channel) o;
        return channelName.equals(channel.channelName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(channelName);
    }
}
