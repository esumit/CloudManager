package com.cloudmanager.apis.ormhelper.ormmodel;

import com.myjeeva.digitalocean.pojo.Network;

import java.util.List;

public class IPV4NetworkInfo {

    public List<Network> getIpv4NetworkInfo() {
        return ipv4NetworkInfo;
    }

    public void setIpv4NetworkInfo(List<Network> ipv4NetworkInfo) {
        this.ipv4NetworkInfo = ipv4NetworkInfo;
    }

    @Override
    public String toString() {
        return "IPV4NetworkInfo{" +
                "ipv4NetworkInfo=" + ipv4NetworkInfo +
                '}';
    }

    List<Network> ipv4NetworkInfo;
}
