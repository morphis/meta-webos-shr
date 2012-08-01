DESCRIPTION = "The Open webOS storage management daemon"
AUTHOR = "Hewlett-Packard Development Company, L.P"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/README.md;md5=76aa6fbe3ee3d5bbff1b96a09c5be6b6"
PV = "2.1.0-rc1+gitr${SRCPV}"
PR = "r1"

DEPENDS = "glib-2.0 cjson-openwebos luna-service2 nyx-lib"

SRC_URI = " \
  git://github.com/openwebos/storaged.git;protocol=http;branch=master"
S = "${WORKDIR}/git"

SRCREV = "55fd020d173fec7d931b5855dfed36d7df063d5c"

inherit cmake

do_install_append() {
  install -d ${D}${datadir}/ls2/roles/prv
  install -d ${D}${datadir}/ls2/services/prv
  install -d ${D}${datadir}/ls2/roles/pub
  install -d ${D}${datadir}/ls2/services/pub

  install -m 0644 ${S}/service/com.palm.storage.json.prv \
    ${D}${datadir}/ls2/roles/prv/com.palm.storage.json
  install -m 0644 ${S}/service/com.palm.storage.json.pub \
    ${D}${datadir}/ls2/roles/prv/com.palm.storage.json

  install -m 0644 ${S}/service/com.palm.storage.service.prv \
    ${D}${datadir}/ls2/services/prv/com.palm.storage.service
  install -m 0644 ${S}/service/com.palm.storage.service.pub \
    ${D}${datadir}/ls2/services/pub/com.palm.storage.service
}

EXTRA_OECMAKE = "-DTARGET_CORE_OS=rockhopper"

FILES_${PN} += "${datadir}/ls2/"
