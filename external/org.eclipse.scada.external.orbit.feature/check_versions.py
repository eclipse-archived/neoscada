from lxml import etree
import argparse
import requests
from collections import namedtuple

Plugin = namedtuple('Plugin', 'id,version') 

def main(release):
    tree = etree.parse("feature.xml")
    
    plugins = []
    for e in tree.getroot():
        if e.tag == 'plugin':
            plugins.append(Plugin(id=e.attrib['id'], version=e.attrib['version']))
            
    orbit = {}
    r = requests.get('http://download.eclipse.org/tools/orbit/downloads/drops/%s/orbitBundles-%s.p2.map' % (release, release))
    for line in r.text.split('\n'):
        if (line.startswith('plugin')):
            p = {}
            for e in line.split(','):
                if '=' in e:
                    p[e.split('=')[0]] = e.split('=')[1]
            if p['id'] not in orbit:
                orbit[p['id']] = set()
            orbit[p['id']].add(p['version'])
    
    for p in plugins:
        if p.version not in orbit[p.id]:
            print p, orbit[p.id]

if __name__=='__main__':
    parser = argparse.ArgumentParser()
    parser.add_argument("release")
    args = parser.parse_args()
    if args.release:
        main(args.release)
