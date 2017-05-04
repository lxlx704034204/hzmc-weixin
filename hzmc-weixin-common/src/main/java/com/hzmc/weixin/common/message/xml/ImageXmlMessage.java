package com.hzmc.weixin.common.message.xml;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.hzmc.weixin.common.message.Media;
import com.hzmc.weixin.common.message.MsgType;
import com.hzmc.weixin.common.message.XmlMessageHeader;

import java.util.Date;

@JacksonXmlRootElement(localName = "xml")
public class ImageXmlMessage extends XmlMessageHeader {

    @JsonProperty("Image")
    private Media media;

    public ImageXmlMessage() {
        this.msgType = MsgType.image;
        this.setCreateTime(new Date());
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public ImageXmlMessage image(String mediaId) {
        this.media = new Media(mediaId);
        return this;
    }
}
