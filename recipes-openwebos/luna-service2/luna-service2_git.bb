DESCRIPTION = "Luna-service2 provides a bus-based IPC mechanism used between components in webOS."
AUTHOR = "Hewlett-Packard Development Company, L.P"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://README.md;md5=0805e6a5927b13bf0f0738f011936c0c"
PV = "3.0.0+gitr${SRCPV}"
PR = "r4"

SRC_URI = " \
  git://github.com/openwebos/luna-service2.git;protocol=http;branch=master \
  file://dont-use-custom-memcpy.patch \
  file://ls-hubd-public.service \
  file://ls-hubd-private.service"
S = "${WORKDIR}/git"

SRCREV = "fdc264f844533eafeb2d3cd6675314c13a15fd67"

DEPENDS = "glib-2.0 cjson-openwebos pmloglib"

inherit cmake systemd

SYSTEMD_PACKAGES = "${PN}-systemd"
SYSTEMD_SERVICE = " \
  ls-hubd-public.service \
  ls-hubd-private.service"

EXTRA_OECMAKE = "-DTARGET_CORE_OS=rockhopper"

do_install_append() {
  install -d ${D}${datadir}/ls2/roles/prv
  install -d ${D}${datadir}/ls2/roles/pub

  install -m 0644 ${S}/service/com.palm.lunasend.json.pub \
    ${D}${datadir}/ls2/roles/pub/com.palm.lunasend.json
  install -m 0644 ${S}/service/com.palm.lunasend.json.prv \
    ${D}${datadir}/ls2/roles/prv/com.palm.lunasend.json

  install -m 0644 ${S}/service/ls-monitor.json.pub \
    ${D}${datadir}/ls2/roles/pub/ls-monitor.json
  install -m 0644 ${S}/service/ls-monitor.json.prv \
    ${D}${datadir}/ls2/roles/prv/ls-monitor.json
}

FILES_${PN} += "${datadir}/ls2/roles/"

pkg_postinst_${PN} () {
  # create system service and roles directories necessary for ls-hub start
  for p in "prv pub" ; do
    mkdir -p ${localstatedir}/palm/ls2/roles/$p
    mkdir -p ${localstatedir}/palm/ls2/services/$p
    mkdir -p ${localstatedir}/mft/palm/ls2/roles/$p
    mkdir -p ${localstatedir}/mft/palm/ls2/system-services/$p
  done
}
