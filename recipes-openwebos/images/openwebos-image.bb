PV = "1.0"
PR = "r0"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

IMAGE_FEATURES += " \
  package-management \
  ssh-server-openssh \
  debug-tweaks \
"

inherit core-image

RDEPENDS_${PN} += " \
  packagegroup-openwebos-systemd \
  opkg"

IMAGE_INSTALL += " \
  packagegroup-core-boot \
  packagegroup-openwebos-systemd \
  opkg \
  luna-service2 \
  nodejs-openwebos \
  sleepd \
  powerd \
  storaged \
  nyx-common-linux-modules \
"
