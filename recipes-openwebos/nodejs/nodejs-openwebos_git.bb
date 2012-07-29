DESCRIPTION = "Open webOS edition of the server-side JavaScript environment that uses a \
asynchronous event-driven model."
AUTHOR = "Joyent, Inc. and other Node contributors"
LICENSE = "MIT & Zlib"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/LICENSE;md5=d6237f3a840aef5b7880fb4e49eecfe5"
PV = "0.4.12-webos2+gitr${SRCPV}"
PR = "r1"

DEPENDS = "openssl"

SRC_URI = "git://github.com/openwebos/nodejs.git;protocol=http;branch=master"
S = "${WORKDIR}/git"
SRCREV = "3cd6a1367e1d697eef8b69f5fd6e35774db93244"

inherit cmake pythonnative

# build out of the source tree, otherwise the build will fail
OECMAKE_SOURCEPATH = ".."
OECMAKE_BUILDPATH = "build"
# select correct core os option; rockhopper is HP/Palms development platform
EXTRA_OECMAKE="-DTARGET_CORE_OS=rockhopper -DCMAKE_SYSTEM_PROCESSOR=arm"
