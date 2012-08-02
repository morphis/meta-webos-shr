DESCRIPTION = "Common linux modules for the Nyx platform portability layer"
LICENSE = "GPL-3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"
PV = "0.1.0+gitr${SRCPV}"
PR = "r1"

DEPEDS = "nyx-lib"

SRC_URI = "git://github.com/morphis/nyx-common-linux-modules.git;protocol=http;branch=master"
S = "${WORKDIR}/git"

SRCREV = "2c20ae6ad0fbd4bfbc508c9979fd5198a82eae56"

inherit autotools

FILES_${PN} += "${libdir}/nyx/modules/*.so"
FILES_${PN} += "${libdir}/nyx/modules/*.la"
FILES_${PN}-dbg += "${libdir}/nyx/modules/.debug/"

pkg_postinst_${PN}() {
  ln -sf nyxSystemCommonLinux.so ${libdir}/nyx/modules/nyxSystemMain.so
  ln -sf nyxLedControllerCommonLinux.so ${libdir}/nyx/modules/nyxLedControllerDefault.so
}

pkg_postrm_${PN}() {
  rm ${libdir}/nyx/modules/nyxSystemMain.so
  rm ${libdir}/nyx/modules/nyxLedControllerDefault.so
}
