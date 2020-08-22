package com.maistruk.hibernate_2;

import java.util.Comparator;

import com.maistruk.hibernate_2.model.SetCollection.CertificateSet;

public class CertificateCompare implements Comparator<CertificateSet>{

    @Override
    public int compare(CertificateSet o1, CertificateSet o2) {
        return o1.getName().compareTo(o2.getName());
    }

}
