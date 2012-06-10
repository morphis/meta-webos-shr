DESCRIPTION = "Enyo is an open source object-oriented JavaScript framework emphasizing \
encapsulation and modularity."
AUTHOR = "Enyo JS Framework Team (HP)"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/LICENSE-2.0.txt;md5=3b83ef96387f14655fc854ddc3c6bd57"
BASE_PV = "2.0.0"
PV = "${BASE_PV}-beta.4+gitr${SRCPV}"
PR = "r0"

SRC_URI = "git://github.com/enyojs/enyo.git;protocol=http;branch=master"
S = "${WORKDIR}/git"

SRCREV = "29ab31b2bd6e449f81768b9c1476e1455c2f47a1"

do_install() {
  mkdir -p ${D}/usr/palm/frameworks/enyo/${BASE_PV}/framework
  cp -r ${S}/source ${D}/usr/palm/frameworks/enyo/${BASE_PV}/framework
  cp ${S}/{enyo.js,loader.js,package.json} ${D}/usr/palm/frameworks/enyo/${BASE_PV}/framework
}

PACKAGES = "${PN}"
FILES_${PN} = "${prefix}/palm/frameworks/enyo/*"
