DESCRIPTION = "The webOS logging library"
AUTHOR = "Hewlett-Packard Development Company, L.P"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/README.md;md5=d33346daa08a48f9ba6aca20edb82da3"
PV = "2.0.0+gitr${SRCPV}"
PR = "r0"

SRC_URI = "git://github.com/openwebos/pmloglib.git;protocol=http;branch=master"
S = "${WORKDIR}/git"

SRCREV = "4ad53ae61d3737b9d2d3d5ab342a1006d402513f"

inherit cmake
