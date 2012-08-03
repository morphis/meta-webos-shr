DESCRIPTION = "LunaSysMgrIpc is the IPC library used by the Luna-SysMgr."
AUTHOR = "Hewlett-Packard Development Company, L.P"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://README.md;md5=eef37ac671c660424016e913a499c2b7"
PV = "1.0.1+gitr${SRCPV}"
PR = "r1"

# only headers in -dev
ALLOW_EMPTY_${PN} = "1"

SRC_URI = " \
  git://github.com/openwebos/luna-sysmgr-ipc.git;protocol=http;branch=master"
S = "${WORKDIR}/git"

SRCREV = "72a942acd45a870cb4d59598b3e6744614c45971"

DEPENDS = "glib-2.0"

inherit autotools

do_install() {
  mkdir -p ${D}${libdir}
  cp ${S}/release-arm/libLunaSysMgrIpc.so ${D}${libdir}
  mkdir -p ${D}${includedir}/luna-sysmgr-ipc
  cp ${S}/ipc/*.h ${D}${includedir}/luna-sysmgr-ipc
}
