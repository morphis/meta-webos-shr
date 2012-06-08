DESCRIPTION = "Netscape Plugin Application Programming Interface (NPAPI)"
AUTHOR = "Netscape Communications Corporation & Hewlett-Packard Development Company, L.P."
LICENSE = "MPL-1.1"
LIC_FILES_CHKSUM = "file://README.md;md5=9ce62e8ce49920968628e9ff12d3e507"

SRC_URI = "git://github.com/isis-project/npapi-headers.git;protocol=http;branch=master"
S = "${WORKDIR}/git"

SRCREV = "d345a2acec381cc0514d165672565f7743073389"
PR = "r0"

do_install() {
  mkdir -p ${D}/${includedir}/webkit/npapi
  cp ${S}/*.h ${D}/${includedir}/webkit/npapi
}

PACKAGES = "${PN}-dev"
FILES_${PN}-dev = "${includedir}/webkit/npapi"

