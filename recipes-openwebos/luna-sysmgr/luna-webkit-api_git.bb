DESCRIPTION = "Public header files from webkit used by luna-sysmgr"
AUTHOR = "Hewlett-Packard Development Company, L.P"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://README.md;md5=f2f847e0412a03d9be71ad3afc9f1a66"
PV = "0.9+gitr${SRCPV}"
PR = "r0"

SRC_URI = " \
  git://github.com/openwebos/luna-webkit-api.git;protocol=http;branch=master"
S = "${WORKDIR}/git"

SRCREV = "554151e62f17f3ffc2fc58fe9d3b22131122f488"

do_install() {
  install -d ${D}${includedir}/ime
  install -m 0644 ${S}/palmimedefines.h ${D}${includedir}/ime/
}
