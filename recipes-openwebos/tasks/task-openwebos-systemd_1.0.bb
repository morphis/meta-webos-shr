DESCRIPTION = "Systemd services needed for Open webOS images"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

inherit task

PACKAGE_ARCH = "${MACHINE_ARCH}"

PR = "r0"

RDEPENDS_${PN} = " \
  luna-service2-systemd \
  sleepd-systemd \
  powerd-systemd \
"
