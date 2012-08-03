DESCRIPTION = "Public header files used by LunaSysMgrIpc, the webOS IPC library used by \
the luna-sysmgr"
AUTHOR = "Hewlett-Packard Development Company, L.P"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://README.md;md5=f0e572a8a2817964cf14a181a34ec7d7"
PV = "1.0.1+gitr${SRCPV}"
PR = "r1"

# only headers in -dev
ALLOW_EMPTY_${PN} = "1"

SRC_URI = " \
  git://github.com/openwebos/luna-sysmgr-ipc-messages.git;protocol=http;branch=master"
S = "${WORKDIR}/git"

SRCREV = "fa93cbd26666cba3928427585b02eb555eb6f81f"

do_install() {
  install -d ${D}${includedir}/sysmgr-ipc
  install -m 0644 ${S}/messages/*.h ${D}${includedir}/sysmgr-ipc/
}
