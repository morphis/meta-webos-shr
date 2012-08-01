DESCRIPTION = "The Open webOS power management daemon"
AUTHOR = "Hewlett-Packard Development Company, L.P"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/README.md;md5=55a6001c5e0219eb260937964862a8a6"
PV = "4.0.0-rc1+gitr${SRCPV}"
PR = "r3"

DEPENDS = "glib-2.0 cjson-openwebos luna-service2 nyx-lib"

SRC_URI = " \
  git://github.com/openwebos/powerd.git;protocol=http;branch=master \
  file://add-missing-dependency-librt.patch \
  file://powerd.service"
S = "${WORKDIR}/git"

SRCREV = "5077891a3430aa6ed5c10b222d82126b44a905cc"

inherit cmake systemd

SYSTEMD_PACKAGES = "${PN}-systemd"
SYSTEMD_SERVICE = "powerd.service"

EXTRA_OECMAKE = "-DTARGET_CORE_OS=rockhopper"

do_install_append() {
  install -d ${D}${datadir}/ls2/roles/prv
  install -d ${D}${datadir}/ls2/services/prv
  install -d ${D}${datadir}/ls2/roles/pub
  install -d ${D}${datadir}/ls2/services/pub

  install -m 0644 ${S}/service/com.palm.power.json.prv \
    ${D}${datadir}/ls2/roles/prv/com.palm.power.json
  install -m 0644 ${S}/service/com.palm.power.json.pub \
    ${D}${datadir}/ls2/roles/prv/com.palm.power.json

  install -m 0644 ${S}/service/com.palm.power.service.prv \
    ${D}${datadir}/ls2/services/prv/com.palm.power.service
  install -m 0644 ${S}/service/com.palm.power.service.pub \
    ${D}${datadir}/ls2/services/pub/com.palm.power.service
}

PACKAGES += "${PN}-upstart"

FILES_${PN} += "${datadir}/ls2/"
FILES_${PN}-upstart = "${sysconfdir}/event.d/powerd"
