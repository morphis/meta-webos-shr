DESCRIPTION = "The Open webOS sleep scheduling daemon"
AUTHOR = "Hewlett-Packard Development Company, L.P"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/README.md;md5=5b6a0fa6d5039ac085000220e04305d5"
PV = "1.1.0-rc1+gitr${SRCPV}"
PR = "r5"

DEPENDS = "glib-2.0 cjson-openwebos luna-service2 nyx-lib powerd sqlite3"

SRC_URI = " \
  git://github.com/openwebos/sleepd.git;protocol=http;branch=master \
  file://fix-ldflags.patch \
  file://sleepd.service"
S = "${WORKDIR}/git"

SRCREV = "9d5ce660eba324e8172117d53690c82431e5dc01"

inherit cmake systemd

SYSTEMD_PACKAGES = "${PN}-systemd"
SYSTEMD_SERVICE = "sleepd.service"

EXTRA_OECMAKE = "-DTARGET_CORE_OS=rockhopper"

do_install_append() {
  install -d ${D}${datadir}/ls2/roles/prv
  install -d ${D}${datadir}/ls2/services/prv
  install -d ${D}${datadir}/ls2/roles/pub
  install -d ${D}${datadir}/ls2/services/pub

  install -m 0644 ${S}/service/com.palm.sleep.json.prv \
    ${D}${datadir}/ls2/roles/prv/com.palm.sleep.json
  install -m 0644 ${S}/service/com.palm.sleep.json.pub \
    ${D}${datadir}/ls2/roles/pub/com.palm.sleep.json

  install -m 0644 ${S}/service/com.palm.sleep.service.prv \
    ${D}${datadir}/ls2/services/prv/com.palm.sleep.service
  install -m 0644 ${S}/service/com.palm.sleep.service.pub \
    ${D}${datadir}/ls2/services/pub/com.palm.sleep.service

  install -d ${D}${localstatedir}/preferences/com.palm.sleep
  install -m 0644 ${S}/preferences/sleepd.conf \
    ${D}${localstatedir}/preferences/com.palm.sleep

}

PACKAGES += "${PN}-upstart"

FILES_${PN} += "${datadir}/ls2/"
FILES_${PN}-upstart = "${sysconfdir}/event.d/sleepd"
