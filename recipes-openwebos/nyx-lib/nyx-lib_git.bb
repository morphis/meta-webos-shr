DESCRIPTION = "The Open webOS portability layer"
AUTHOR = "Hewlett-Packard Development Company, L.P"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/README.md;md5=ee53e8901568a36f0fa64432098d035f"
PV = "2.0.0+gitr${SRCPV}"
PR = "r2"

DEPEDS = "glib-2.0"

SRC_URI = " \
  git://github.com/openwebos/nyx-lib.git;protocol=http;branch=master \
  file://0001-Expose-module-directory-in-pkg-config-configuration-.patch \
  file://0002-Use-.so-as-module-suffix-rather-than-not-common-.mod.patch \
  file://0001-Put-modules-in-usr-lib-and-not-lib-as-this-violates-.patch \
  file://0002-Don-t-use-multiarch-paths-right-now-for-a-OE-target-.patch"
S = "${WORKDIR}/git"

SRCREV = "ce3549276be5ba60129542222e327c25088cf2a9"

inherit cmake

EXTRA_OECMAKE = "-DTARGET=rockhopper"
