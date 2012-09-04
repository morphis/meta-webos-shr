require openwebos-image.bb

# usefull only for devs and automated builds to force do_rootfs for all packages we have in feed

RDEPENDS_${PN} += " \
  packagegroup-openwebos-all \
"

IMAGE_INSTALL += " \
  packagegroup-openwebos-all \
"
