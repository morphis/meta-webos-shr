DESCRIPTION = "Systemd services needed for Open webOS images"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

PR = "r1"

RPROVIDES_${PN} += "task-openwebos-systemd"
RREPLACES_${PN} += "task-openwebos-systemd"
RCONFLICTS_${PN} += "task-openwebos-systemd"

RDEPENDS_${PN} = " \
  luna-service2-systemd \
  sleepd-systemd \
  powerd-systemd \
"
