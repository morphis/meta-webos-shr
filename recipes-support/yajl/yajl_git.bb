DESCRIPTION = "Yet Another JSON Library. YAJL is a small event-driven (SAX-style) JSON \
parser written in ANSI C, and a small validating JSON generator."
AUTHOR = "Lloyd Hilaiel <lloyd@hilaiel.com>"
LICENSE = "ISC"
LIC_FILES_CHKSUM = "file://COPYING;md5=3c388455eccfb12636b7af50a1eb563c"
PR = "r0"
PV = "1.0.4+gitr${SRCPV}"

SRC_URI = "git://github.com/lloyd/yajl;protocol=http;branch=master"
S = "${WORKDIR}/git"

# NOTE this is fixed to the 1.0.4 version; don't change this!
SRCREV = "8804b2841f04f6e101638a59fcd318ebc00a017c"

inherit cmake

do_configure_append() {
  for i in $(find ${S} -name "Makefile") ; do
    sed -i -e s:-Werror::g $i
  done
}
