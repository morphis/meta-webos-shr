DESCRIPTION = "Common linux modules for the Nyx platform portability layer"
LICENSE = "GPL-3"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/COPYING;md5=d32239bcb673463ab874e80d47fae504"
PV = "0.1.0+gitr${SRCPV}"
PR = "r0"

DEPEDS = "nyx-lib"

SRC_URI = "git://github.com/morphis/nyx-common-linux-modules.git;protocol=http;branch=master"
S = "${WORKDIR}/git"

SRCREV = "d9c1094980eb31bd7b4f358f21f4b801d70708b9"

inherit autotools

FILES_${PN} += "${libdir}/nyx/modules/"
FILES_${PN}-dbg += "${libdir}/nyx/modules/.debug/"