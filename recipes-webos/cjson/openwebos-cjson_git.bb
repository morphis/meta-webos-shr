DESCRIPTION = "An ultra-lightweight, portable, single-file, simple-as-can-be ANSI-C \
compliant JSON parse"
AUTHOR = "Metaparadigm Pte Ltd & Hewlett-Packard Development Company, L.P"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/COPYING;md5=30a276a476b02c2dcd0849bde417fb17"
PV = "1.8.0+gitr${SRCPV}"
PR = "r0"

SRC_URI = "git://github.com/openwebos/cjson.git;protocol=http;branch=master"
S = "${WORKDIR}/git"

SRCREV = "43de024867b8d38f607f04cfede8608ce532a8e6"

inherit autotools
